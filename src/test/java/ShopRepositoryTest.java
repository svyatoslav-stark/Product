import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopRepositoryTest {

    @Test
    void shouldAddProductsToRepository() {
        ShopRepository repository = new ShopRepository();
        repository.add(new Product(1, "Book", 100));
        repository.add(new Product(2, "Pen", 50));

        Product[] allProducts = repository.findAll();
        assertEquals(2, allProducts.length);
        assertEquals(1, allProducts[0].getId());
        assertEquals("Book", allProducts[0].getTitle());
        assertEquals(100, allProducts[0].getPrice());
        assertEquals(2, allProducts[1].getId());
        assertEquals("Pen", allProducts[1].getTitle());
        assertEquals(50, allProducts[1].getPrice());
    }

    @Test
    public void testRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] products = repository.findAll();
        assertEquals(1, products.length);
        assertEquals(2, products[0].getId());
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);

        repository.add(product1);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(2),
                "Element with id: 2 not found");
    }

    @Test
    public void testFindByIdExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);

        repository.add(product1);

        Product found = repository.findById(1);
        Assertions.assertNotNull(found);
        assertEquals(1, found.getId());
    }

    @Test
    public void testFindByIdNonExistingProduct() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);

        repository.add(product1);

        Product found = repository.findById(2);
        Assertions.assertNull(found);
    }
}
