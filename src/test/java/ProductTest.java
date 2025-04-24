import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductTest {

    @Test
    public void testConstructorAndGetters() {
        Product product = new Product(1, "Test Product", 1000);

        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("Test Product", product.getTitle());
        Assertions.assertEquals(1000, product.getPrice());
    }

    @Test
    public void testSetters() {
        Product product = new Product(1, "Initial Title", 500);

        product.setTitle("Updated Title");
        product.setPrice(750);

        Assertions.assertEquals("Updated Title", product.getTitle());
        Assertions.assertEquals(750, product.getPrice());
    }

    @Test
    public void testEqualsWithSameObject() {
        Product product = new Product(1, "Product", 100);

        Assertions.assertTrue(product.equals(product));
    }

    @Test
    public void testEqualsWithEqualObjects() {
        Product product1 = new Product(1, "Product", 100);
        Product product2 = new Product(1, "Product", 100);

        Assertions.assertTrue(product1.equals(product2));
    }

    @Test
    public void testEqualsWithDifferentIds() {
        Product product1 = new Product(1, "Product", 100);
        Product product2 = new Product(2, "Product", 100);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void testEqualsWithDifferentTitles() {
        Product product1 = new Product(1, "Product A", 100);
        Product product2 = new Product(1, "Product B", 100);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void testEqualsWithDifferentPrices() {
        Product product1 = new Product(1, "Product", 100);
        Product product2 = new Product(1, "Product", 200);

        Assertions.assertFalse(product1.equals(product2));
    }

    @Test
    public void testEqualsWithNull() {
        Product product = new Product(1, "Product", 100);

        Assertions.assertFalse(product.equals(null));
    }

    @Test
    public void testEqualsWithDifferentClass() {
        Product product = new Product(1, "Product", 100);
        Object other = new Object();

        Assertions.assertFalse(product.equals(other));
    }

    @Test
    public void testHashCodeConsistency() {
        Product product = new Product(1, "Product", 100);
        int initialHashCode = product.hashCode();

        Assertions.assertEquals(initialHashCode, product.hashCode());
    }

    @Test
    public void testHashCodeEquality() {
        Product product1 = new Product(1, "Product", 100);
        Product product2 = new Product(1, "Product", 100);

        Assertions.assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void testHashCodeInequality() {
        Product product1 = new Product(1, "Product A", 100);
        Product product2 = new Product(2, "Product B", 200);

        Assertions.assertNotEquals(product1.hashCode(), product2.hashCode());
    }
}
