package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SqlTracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceOneItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item third = new Item("Third");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(third);
        tracker.replace(third.getId(), second);
        assertThat(tracker.findById(third.getId()).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenAddThreeItemsThenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item third = new Item("Third");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> list = List.of(first, second, third);
        assertThat(tracker.findAll()).containsAll(list);
    }

    @Test
    public void whenAddThreeItemsThenDeleteAllOfItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item third = new Item("Third");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> list = List.of(first, second, third);
        assertThat(tracker.findAll()).containsAll(list);
        tracker.delete(first.getId());
        tracker.delete(second.getId());
        tracker.delete(third.getId());
        assertThat(tracker.findAll()).doesNotContainAnyElementsOf(list);
    }

    @Test
    public void whenAddTwoItemsThenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        List<Item> exp = List.of(second);
        assertThat(tracker.findByName("Second")).isEqualTo(exp);
    }

    @Test
    public void whenDoesNotContainName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("First");
        tracker.add(first);
        List<Item> exp = List.of();
        assertThat(tracker.findByName("Second")).isEqualTo(exp);
    }
}