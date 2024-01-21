### Наследование реализации

```java
// Базовый класс для всех умных устройств в доме
class SmartDevice {
    private boolean on;

    public SmartDevice() {
        this.on = false;
    }

    public void turnOn() {
        on = true;
        System.out.println("Устройство включено.");
    }

    public void turnOff() {
        on = false;
        System.out.println("Устройство выключено.");
    }

    public boolean isOn() {
        return on;
    }
}

// Класс умной лампы. Наследуется от SmartDevice и добавляет регулировку яркости
class SmartLight extends SmartDevice {
    private int brightness;

    public SmartLight() {
        super();
        this.brightness = 0; // начальная яркость
    }

    public void setBrightness(int brightness) {
        if(brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
            System.out.println("Яркость установлена на уровень: " + brightness + "%.");
        } else {
            System.out.println("Неверный уровень яркости. Установлено значение от 0 до 100.");
        }
    }

    public int getBrightness() {
        return brightness;
    }
}

```

### Льготное наследование

Пример льготного наследования, когда тип Button является частным случаем UI-элемента TextView и базово просто меняет Background.

```java
public class TextView extends View {
    public void setText(CharSequence text) {
        // установка текста в элемент
    }
    
    public void setTextColor(int color) {
        // установка цвета текста
    }
}

public class Button extends TextView {
    public Button(Context context) {
        this(context, null);
    }
    
    public Button(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.buttonStyle);
    }
    
    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }
    
    public Button(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
```