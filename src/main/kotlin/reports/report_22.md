В моем решении класс использовалось льготное наследование и наследование реализации, базовый тип формировался отношением has-a. В целом, такой подход можно было бы применить и в эталонном решении и тогда не будет необходимости выбирать, какой тип сделать основным без знания ограничений предметной области.

В целом, оба решения удовлетворяют условию задачи, при наследовании вида стоит иметь в голове критерии из лекции, которые будут служить триггерами для создания такой категории наследования. 

**Пример решения:**

```java
interface Material {
     // материал для шитья
    void sew();
}

class Wool implements Material {
    @Override
    public void sew() {}
}

class Cotton implements Material {
    @Override
    public void sew() {}
}

interface Clothes {
    // материалы, из которых изготовлена вещь
    Material[] getMaterials();

    // надеть одежду
    void putOn();
    int getSize();
    String getBrand();
}

class Blouses implements Clothes {
    private final Material[] materials;
    private final String brand;
    private final int size;

    public Blouses(Material[] materials, String brand, int size) {
        this.materials = materials;
        this.brand = brand;
        this.size = size;
    }

    @Override
    public Material[] getMaterials() {
        return new Material[0];
    }

    @Override
    public void putOn() {}

    @Override
    public int getSize() {
      return this.size;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}

class Trousers implements Clothes {

    private final Material[] materials;
    private final String brand;
    private final int size;

    public Trousers(Material[] materials, String brand, int size) {
        this.materials = materials;
        this.brand = brand;
        this.size = size;
    }

    @Override
    public Material[] getMaterials() {
        return new Material[0];
    }

    @Override
    public void putOn() {}

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}
```
Имеется класс "Одежда", от которого наследуются классы "Брюки" и "Блузки".
Одежда предполагает несколько связанных сущностей, определяющих состояние вещи.
В частности, одежда характеризуется формой и материалом, из которого она сделана. Оба этих признака часто используются вместе.
Признак формы логично выделить основным: клиента интересует различие прежде всего между брюками и блузками, а не между материалами, из которых они сделаны.
Поэтому признак материала выделен в отдельную иерархию -- он находится в отношении композиции с классом одежда (одежда содержит материал).
