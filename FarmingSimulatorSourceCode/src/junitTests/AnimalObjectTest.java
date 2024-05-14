package junitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import farmSim.Animal;
import farmSim.Chicken;
import farmSim.Cow;
import farmSim.Sheep;

public class AnimalObjectTest {

    Animal testAnimal;
    
    @Before
    public void setupAnimalForTest(){
        testAnimal = new Animal("Cow", 50);
    }

    @Test
    public void animalConstructorNormal() {
        assertEquals(testAnimal.getAnimalType(), "Cow");
        assertEquals(testAnimal.getBaseIncome(), 50);
        assertEquals(testAnimal.getHappiness(), 70);
        assertEquals(testAnimal.getHealth(), 70);
    }
    
    @Test
    public void animalChangeHealthTest() {
        testAnimal.changeHealth(5);
        assertEquals(testAnimal.getHealth(), 65);
    }
    
    @Test
    public void animalChangeHappinessTest() {
        testAnimal.changeHappiness(5);
        assertEquals(testAnimal.getHappiness(), 65);
    }
    
    @Test
    public void getIncomeTest() {
        float income = testAnimal.getIncome();
        assertEquals(income, 24.5, 0.01);
    }
    
    @Test
    public void playWithAnimalTest() {
        testAnimal.playWithAnimal();
        assertEquals(90, testAnimal.getHappiness());
    }
    
    @Test
    public void feedAnimalTest() {
        testAnimal.feedAnimal(20, 20);
        assertEquals(90, testAnimal.getHealth());
        assertEquals(90, testAnimal.getHappiness());
    }
    
    @Test
    public void getAnimalDecriptionTest() {
        assertEquals("Cow\nHappiness: 70\nHealth: 70", testAnimal.getAnimalDescription());
        
    }
    
    @Test
    public void animalConstructorSaveFile() {
        testAnimal = new Animal("Cow", 40, 25, 35);
        assertEquals("Cow", testAnimal.getAnimalType());
        assertEquals(40, testAnimal.getBaseIncome());
        assertEquals(25, testAnimal.getHappiness());
        assertEquals(35, testAnimal.getHealth());
    }
    
    @Test
    public void animalSheepChildTest() {
        Sheep testSheep = new Sheep();
        assertEquals("Sheep", testSheep.getAnimalType());
        assertEquals(20, testSheep.getBaseIncome());
        
        Sheep testSheep2 = new Sheep(35, 45);
        assertEquals("Sheep", testSheep2.getAnimalType());
        assertEquals(20, testSheep2.getBaseIncome());
        assertEquals(35, testSheep2.getHappiness());
        assertEquals(45, testSheep2.getHealth());
    }
    
    @Test
    public void animalCowChildTest() {
        Cow testCow = new Cow();
        assertEquals("Cow", testCow.getAnimalType());
        assertEquals(25, testCow.getBaseIncome());
        
        Cow testCow2 = new Cow(35, 45);
        assertEquals("Cow", testCow2.getAnimalType());
        assertEquals(25, testCow2.getBaseIncome());
        assertEquals(35, testCow2.getHappiness());
        assertEquals(45, testCow2.getHealth());
    }
    
    @Test
    public void animalChickenChildTest() {
        Chicken testChicken = new Chicken();
        assertEquals("Chicken", testChicken.getAnimalType());
        assertEquals(15, testChicken.getBaseIncome());
        
        Chicken testChicken2 = new Chicken(35, 45);
        assertEquals("Chicken", testChicken2.getAnimalType());
        assertEquals(15, testChicken2.getBaseIncome());
        assertEquals(35, testChicken2.getHappiness());
        assertEquals(45, testChicken2.getHealth());
    }
}
