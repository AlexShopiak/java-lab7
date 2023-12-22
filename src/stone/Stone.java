/*
 * Stone
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * Stone class is a super class for future types of stones
 */
package stone;

public class Stone{
    private static final int MIN_CLR = 1;
    private static final int MAX_CLR = 10;

    private int weightInCarats;
    private int priceInUSDByCarat;
    private int clarity;

    public Stone(int weight, int price, int clarity) {
        this.weightInCarats = weight;
        this.priceInUSDByCarat = price;
        validateClarity(clarity);
        this.clarity = clarity;
    }

    public void validateClarity(int clarity) {
        if ((clarity < MIN_CLR) || (clarity > MAX_CLR)) {
            throw new IllegalArgumentException("Clarity must be 1-10");
        }
    }

    public int getWeight() {
        return weightInCarats;
    }

    public int getPrice() {
        return priceInUSDByCarat * weightInCarats * clarity / MAX_CLR;
    }

    public int getClarity() {
        return clarity;
    }
}


/*
 * Precious Stone class and its childs
 */
class PreciousStone extends Stone{
    PreciousStone(int weight, int price, int clarity) {
        super(weight, price, clarity);
    }
}

class Diamond extends PreciousStone{
    Diamond(int weight, int clarity) {
        super(weight, 3500, clarity);
    }
}

class Emerald extends PreciousStone{
    Emerald(int weight, int clarity) {
        super(weight, 3000, clarity);
    }
}

class Ruby extends PreciousStone{
    Ruby(int weight, int clarity) {
        super(weight, 3400, clarity);
    }
}


/*
 * Semi-Precious Stone class and its childs
 */
class SemiPreciousStone extends Stone{
    SemiPreciousStone(int weight, int price, int clarity) {
        super(weight, price, clarity);
    }
}

class Onyx extends SemiPreciousStone{
    Onyx(int weight, int clarity) {
        super(weight, 50, clarity);
    }
}

class Opal extends SemiPreciousStone{
    Opal(int weight, int clarity) {
        super(weight, 200, clarity);
    }
}

class Pearl extends SemiPreciousStone{
    Pearl(int weight, int clarity) {
        super(weight, 100, clarity);
    }
}
