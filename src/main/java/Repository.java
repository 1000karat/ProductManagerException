public class Repository {
    private Product[] items = new Product[0]; // хранит массив продуктов

    public void save(Product newItem) { //1
        //создаём новый массив, вычисляем длинну + 1
        Product[] tmp = new Product[items.length + 1];
        //копируем: откуда копируем, с какой позиции начинаем, куда копируем, с какой позиции копируем, сколько копируем
        System.arraycopy(items, 0, tmp, 0, items.length);
        //последняя ячейка
        tmp[tmp.length - 1] = newItem;
        items = tmp;
    }

    public void removeById(int id) { //3
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public Product[] findAll() { //2
        return items;
    }
}

    /*
3. Разработайте репозиторий, позволяющий:
сохранять Product'ы,
получать все сохранённые Product'ы и
удалять по id.
Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).
 */
