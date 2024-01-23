1. Наследование реализации можно представить как переход к более высокому уровню абстракции на фундаменте класса-родителя. В моем примере оказался уровень абстракции у класса-потомка такой же, как у класса-родителя
2. Льготное наследование представляет некий частный случай класса-родителя, решение корректное, но на примере с Exception и Response эта категория наследования более отчетливо просматривается.

**Эталонное решение:**

Наследование реализации: класс "диаграмма классов" наследует реализацию класса "дерево", так как для хранения дерева иерархии классоа не требуется особая структура данных. Достаточно использовать стандартное дерево, возможно, расширив его небольшим числом специфичных операций.

```java

class Tree<T> {

    public Tree(T rootData) { ... }
    public void add(T parent, T value) { ... }
    private Node<T> searchNode(Node<T> currentNode, T value) { ... }
}


class ClassDiagram extends Tree<Class> {

    public ClassDiagram(Class rootData) {
        super(rootData);
    }
}

//Льготное наследование: наследование класса FailedAmazonS3Response от класса HttpResponse. Ответ про сбой от хранилища Amazon S3 -- по сути, обычный ответ на http-запрос, который внутри себя содержит как стандарные сведения, так и дополнительную уточняющую информацию.

class HttpResponse {
    private int statusCode;
    private byte[] body;

    public HttpResponse(int statusCode, byte[] body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}

class FailedAmazonS3Response extends HttpResponse {
    private String key;
    private String bucketName;
    private String region;

    public FailedAmazonS3Response(String key, String bucketName, 
            String region, int statusCode, byte[] body) {
        super(statusCode, body);
        this.key = key;
        this.bucketName = bucketName;
        this.region = region;
    }
}
```
