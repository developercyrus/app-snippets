package design.pattern.proxydynamic.a1;

public class Main {
    public static void main(String[] args) {       
        Animal bird = new Bird();
        Animal birdProxy = (Animal)BirdProxy.createProxy(bird);
        birdProxy.hello("Mary");
    }
}
