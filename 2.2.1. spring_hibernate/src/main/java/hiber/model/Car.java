package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int series;

    @Column
    private String model;

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "\t 2.1. Модель автомобиля: " +
                "model='" + getModel() + '\'' + "\n" +
                "\t 2.2. Серия автомобиля: " + getSeries() + "\n";
    }
}
