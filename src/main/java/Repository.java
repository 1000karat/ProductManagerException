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

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found!");
        }
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

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return items;
    }
}

    /*
В методе удаления removeById сначала проверяйте,
есть ли элемент (для этого прямо из метода removeById вызывайте метод findById (про него ниже):
Для реализации этой логики вам понадобится добавить метод findById, предназначенный для поиска товара в репозитории по его id.

Так, он должен принимать параметром id искомого товара, пробегаться по всем товарам репозитория и сверять их id с искомом, в случае совпадения делать return этого товара.
Если же пробежав все товары репозитория ни один подходящий найден не был (т.е. цикл закончился без вызова return внутри него), то следует сделать return null.

Общая схема этого метода будет такой:

public Product findById(???) {
  for (???) {
    if (???) {
      return product;
    }
  }
  return null;
}

если результат - null, тогда выкидывайте исключение NotFoundException)
*/
