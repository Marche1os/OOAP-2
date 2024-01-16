1. Наследование вариаций. По логике мое решение корректно соотносится с эталонным, так как наследование с вариацией типа подразумевает изменение родительского метода
2. Наследование с конкретизацией. В эталонном примере несколько иначе показан данный тип наследования, однако оба решения показывают его суть: классическое наследование поведения класса-родителя с дополненными требованиями
3. Структурное наследование. Решения также показывают суть данного типа наследования: когда как бы расширяем тип новым поведением, новыми возможностями, которые лежат как бы вне иерархической цепочке наследования.

**Пример решения:**

Java

Наследование вариаций: иерархия "обычная газовая плита GasStove - газовая плита с электоподжигом ElectricGasStove", так как процесс её зажигания не требует спичек.

```java
class GasStove {
private boolean isGasTurnedOn;
private boolean isGasFired;

    public void turnOn(Match match) {
        match.setFired();
        turnOnGas();
        isGasFired = true;
    }

    protected void turnOnGas() {
        isGasTurnedOn = true;
    }
}

class ElectricGasStove extends GasStove {
//@Override
public void turnOn() {
    turnOnGas();
    turnOnElectricIgnition();
}

    private void turnOnElectricIgnition() {

    }
}
//Наследование с функциональной вариацией: иерархия классов HttpRequest и HttpsRequest. HTTPS-запрос помимо перадачи данных требует предварительно создать ключ сессии, которым шифруются данныею

class HttpRequest {
void doRequest(String body, Map<String, String> headers, String url) {
dataInterchange(body, headers, url);
}

    protected void dataInterchange(String body, Map<String, String> headers, String url) {
        System.out.println("");
    }
}

class HttpsRequest extends HttpRequest {
protected String secretKey;

    @Override
    void doRequest(String body, Map<String, String> headers, String url) {
        handshake(url);
        var encryptedBody = encrypt(body, this.secretKey);
        super.doRequest(encryptedBody, headers, url);
    }

    private void handshake(String url) {
        var certificate = getServerCertificate(url);

        var canTrust = checkCertificateInCertificateAuthority(certificate);
        if (canTrust) {
            var publicKey = getPublicKeyFromCertificate(certificate);
            this.secretKey = createSecretKey();
            var encryptedSecretKey = encrypt(secretKey, publicKey);
            super.dataInterchange(encryptedSecretKey, null, url);
        }
    }

    private String createSecretKey() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE));
    }

    private String encrypt(String text, String key) {
        return text; // ... дополнительные действия
    }

    private String getPublicKeyFromCertificate(String certificate) {
        return certificate.substring(0, 10);
    }

    private String getServerCertificate(String url) {
        // заглушка
        return "some certificate";
    }

    private boolean checkCertificateInCertificateAuthority(String certificate) {
        // более сложная логика
        return true;
    }
}
//Структурное наследование: наследование класса от интерфейса Summable, который добавляет классу "возможность" суммирования. Это полезно при работе с разными математическими понятиями, поддерживающими операцию суммирования -- например для скаляров (MyInt) и векторов (Vector).

enum OperationResult {
    SUCCESS,
    FAILURE
}

abstract class Summable extends Any {
    abstract void sum(Summable number);
    abstract int getLength();
    abstract OperationResult getSumOperationResult();
    abstract List<Summable> getValues();
}

class MyInt extends Summable {
    private OperationResult addOperationResult;

    int value;

    public MyInt(int value) {
        this.value = value;
    }

    @Override
    void sum(Summable number) {
        if (number.getLength() != this.getLength()) {
            return ;
        }

        MyInt myInt = new MyInt(0);
        myInt = Any.assignmentAttempt(number, myInt);
        if (myInt == null) {
            addOperationResult = OperationResult.FAILURE;
            return;
        }

        this.value += myInt.value;
        addOperationResult = OperationResult.SUCCESS;
    }

    @Override
    int getLength() {
        return 1;
    }

    @Override
    OperationResult getSumOperationResult() {
        return this.addOperationResult;
    }

    @Override
    List<Summable> getValues() {
        var list = new ArrayList<Summable>();
        list.add(new MyInt(this.value));
        return list;
    }
}
```