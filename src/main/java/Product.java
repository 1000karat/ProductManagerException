public class Product {
    private int id;
    private String name;
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

/*
1.Разработайте базовый класс Product, содержащий id, название, стоимость
2. Разработать два унаследованных от Product класса: Book (с текстовыми полями название и автор) и Smartphone (с текстовыми полями название и производитель);
общие поля вынесите в родителя.
3. Разработайте репозиторий, позволяющий сохранять Product'ы, получать все сохранённые Product'ы и удалять по id. Для этого репозиторий будет хранить у себя
поле с типом Product[] (массив товаров).

4. Разработайте менеджера, который умеет добавлять Product'ы в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс, конструктор
которого будет принимать параметром репозиторий, а также с методом publiс void add(Product product) и методом поиска (см. ниже).
 */
