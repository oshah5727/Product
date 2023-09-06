import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3, p4, p5;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600.0);
        p2 = new Product("000002", "Lembas", "Elven Wayfare Bread", 200.0);
        p3 = new Product("000003", "Wine", "Woodland Elf Wine", 400.0);
        p4 = new Product("000004", "Mushrooms", "Farmer Took's Finest", 125.0);
        p5 = new Product("000005", "Mithril", "Enchanted Dwarven Armor", 3000.0);
    }

    @Test
    void setID() {

        p1.setID("000005");
        assertEquals("000005", p1.getID());

        p2.setID("000004");
        assertEquals("000004", p2.getID());

        p3.setID("000003");
        assertEquals("000003", p3.getID());

        p4.setID("000002");
        assertEquals("000002", p4.getID());

        p5.setID("000001");
        assertEquals("000001", p5.getID());

    }

    @Test
    void setName() {

        p1.setName("Mithril");
        assertEquals("Mithril", p1.getName());

        p2.setName("Mushrooms");
        assertEquals("Mushrooms", p2.getName());

        p3.setName("Wine");
        assertEquals("Wine", p3.getName());

        p4.setName("Lembas");
        assertEquals("Lembas", p4.getName());

        p5.setName("Pipeweed");
        assertEquals("Pipeweed", p5.getName());


    }

    @Test
    void setDescription() {

        p1.setDescription("Enchanted Dwarven Armor");
        assertEquals("Enchanted Dwarven Armor", p1.getDescription());

        p2.setDescription("Farmer Took's Finest");
        assertEquals("Farmer Took's Finest", p2.getDescription());

        p3.setDescription("Woodland Elf Wine");
        assertEquals("Woodland Elf Wine", p3.getDescription());

        p4.setDescription("Elven Wayfare Bread");
        assertEquals("Elven Wayfare Bread", p4.getDescription());

        p5.setDescription("Long Bottom Leaf");
        assertEquals("Long Bottom Leaf", p5.getDescription());
    }

    @Test
    void setCost() {

        p1.setCost(3000.0);
        assertEquals(3000.0, p1.getCost());

        p2.setCost(125.0);
        assertEquals(125.0, p2.getCost());

        p3.setCost(400.0);
        assertEquals(400.0, p3.getCost());

        p4.setCost(200.0);
        assertEquals(200.0, p4.getCost());

        p5.setCost(600.0);
        assertEquals(600.0, p5.getCost());

    }

    @Test
    void toCSVDataRecord() {
        assertEquals("000001, Pipeweed, Long Bottom Leaf, 600.0", p1.toCSVDataRecord());
        assertEquals("000002, Lembas, Elven Wayfare Bread, 200.0", p2.toCSVDataRecord());
        assertEquals("000003, Wine, Woodland Elf Wine, 400.0", p3.toCSVDataRecord());
        assertEquals("000004, Mushrooms, Farmer Took's Finest, 125.0", p4.toCSVDataRecord());
        assertEquals("000005, Mithril, Enchanted Dwarven Armor, 3000.0", p5.toCSVDataRecord());
    }

    @Test
    void testToString() {
        assertEquals("Product{ID='000001', name='Pipeweed', description='Long Bottom Leaf', cost=600.0}", p1.toString());
        assertEquals("Product{ID='000002', name='Lembas', description='Elven Wayfare Bread', cost=200.0}", p2.toString());
        assertEquals("Product{ID='000003', name='Wine', description='Woodland Elf Wine', cost=400.0}", p3.toString());
        assertEquals("Product{ID='000004', name='Mushrooms', description='Farmer Took's Finest', cost=125.0}", p4.toString());
        assertEquals("Product{ID='000005', name='Mithril', description='Enchanted Dwarven Armor', cost=3000.0}", p5.toString());
    }
}
