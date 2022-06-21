import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionTest {
    private final Repository repository = new Repository();
    Product product1 = new Product(1, "Name1", 100);
    Product product2 = new Product(2, "Name2", 200);
    Product product3 = new Product(3, "Name3", 300);
    Product book1 = new Book(4, "Name4", 400, "Author1");
    Product book2 = new Book(5, "Name5", 500, "Author2");
    Product book3 = new Book(6, "Name6", 600, "Author3");
    Product smart1 = new Smartphone(7, "Name7", 700, "manufacturer1");
    Product smart2 = new Smartphone(8, "Name8", 800, "manufacturer2");
    Product smart3 = new Smartphone(9, "Name9", 900, "manufacturer3");

    @Test
    void shouldRemoveByIdThree() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);
        repository.save(smart3);

        repository.removeById(2);

        Product[] expected = {product1, product3, book1, book2, book3, smart1, smart2, smart3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void shouldRemoveByIdException() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smart1);
        repository.save(smart2);
        repository.save(smart3);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(50);
        });
    }

    @Test
    void shouldRemoveByIdExceptionTwo() {

        //repository.removeById(-1);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-1);
        });
    }

}

/*
Напишите 2 автотеста на репозиторий:
        первый должен проверять успешность удаления существующего элемента,
        второй - генерации NotFoundException при попытке удаления несуществующего элемента
        */
