Сравнивая решения, не очень понял момент "метод скрыт в родительском и публичен в его потомке". Почему protected принят за скрытый метод, если скрытый метод - это приватный метод с модификатором `private`?

Как бы то ни было, можно заключить одно правило: область видимости метода дочернего класса должна быть не строже области видимости метода родительского класса. Это правило для языков Kotlin и Java.

Пример решения:

```java
class A extends Any {
    private int a;
    private int b;
    private int c;
    private int d;

    //метод публичен в родительском классе А 
    //и публичен в его потомке B;
    public int getA() {
        return this.a;
    }

    //метод скрыт в родительском классе А 
    //и публичен в его потомке B;
    protected int getB() {
        return this.b;
    }

    //метод публичен в родительском классе А 
    //и скрыт в его потомке B
    // -- такая видимость методов в иерархии невозможна,
    // так как в классах-наследниках доступ у метода 
    //должны быть таким же или более слабым
    public int getC() {
        return this.c;
    }

    //метод скрыт в родительском классе А 
    //и скрыт в его потомке B.
    protected int getD() {
        return this.d;
    }
}
class B extends A {

    @Override
    public int getA() {
        return super.getA() + 1;
    }

    @Override
    public int getB() {
        return this.getB() + 2;
    }

    /*@Override
    private int getC() {
        return super.getC();
    }*/

    @Override
    protected int getD() {
        return super.getD() + 4;
    }
}
```