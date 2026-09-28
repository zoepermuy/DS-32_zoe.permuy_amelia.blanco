package e3;

import java.util.Arrays;

public record Triangle(int angle1, int angle2, int angle3) {
    public Triangle {
        if (angle1 + angle2 + angle3 != 180) {
            throw new IllegalArgumentException("La suma de los angulos no suman 180 grados.");
        }
    }

    public Triangle(Triangle t) {
        this(t.angle1, t.angle2, t.angle3);
    }

    public boolean isRight() {
        return angle1 == 90 || angle2 == 90 || angle3 == 90;
    }

    public boolean isAcute() {
        return angle1 < 90 && angle2 < 90 && angle3 < 90;
    }

    public boolean isObtuse() {
        return angle1 > 90 || angle2 > 90 || angle3 > 90;
    }

    public boolean isEquilateral() {
        return angle1 == angle2 && angle2 == angle3;
    }

    public boolean isIsosceles() {
        if (isEquilateral()) {
            return false; // Un triángulo equilátero no es isósceles
        }
        return angle1 == angle2 || angle2 == angle3 || angle1 == angle3;
    }

    public boolean isScalene() {
        return angle1 != angle2 && angle2 != angle3 && angle1 != angle3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle other)) return false; //comprobar que el objeto sea un Triangle
        int[] angles1 = {angle1, angle2, angle3};
        int[] angles2 = {other.angle1, other.angle2, other.angle3};

        Arrays.sort(angles1);
        Arrays.sort(angles2); //ordenamos los angulos para la comparacion de menor a mayor

        return Arrays.equals(angles1, angles2);
    }

    @Override
    public int hashCode() {
        int[] angles = {angle1, angle2, angle3};
        Arrays.sort(angles);
        return Arrays.hashCode(angles);
    }
}
