В целом идея решения схожа, сериализация/десериализация осуществляется через Json и в целом будет неплохо иметь такую универсальную структуру для копирования объектов.

Идея создания базовой структуры может применяться и при построении модуля как логической единицы предметной области. 
Например, есть сущность "Умное устройство". Это будет самостоятельный тип с интерфейсом взаимодействия, но этот тип будет входить в иерархию типов всех умных устройств, которые будут иметь как-бы language-core функционал. 
К примеру, специфичный метод equals. 

Также можно будет сделать АТД умного устройства с функциями, которые осуществляют спецефичные манипуляции над этой структурой. 

**Пример решения:**

```java
class General implements Serializable {
    public <T> void deepCopy(T target) throws Exception {
        try {
            target = getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    public <T> T deepClone() throws Exception {
        try {
            return getCopy();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public <T> String serialize() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.writeValueAsString((T)this);
    }

    public static <T> T deserialize(
                        String json, 
                        Class<T> clazz) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @JsonIgnore
    public final Class<?> getType() {
        return this.getClass();
    }

    private <T> T getCopy() throws Exception  {
        try {
            var byteArrayOutputStream = new ByteArrayOutputStream();
            var objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject((T)this);
            var bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            var objectInputStream = new ObjectInputStream(bais);

            return (T) objectInputStream.readObject();
        }
        catch (Exception e) {
            throw e;
        }
    }
}

/*public*/ class Any extends General {

}
```