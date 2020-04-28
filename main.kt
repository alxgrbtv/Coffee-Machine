import java.util.*

val scanner = Scanner(System.`in`)
var waterInMachine = 400
var milkInMachine = 540
var beansInMachine = 120
var cups = 9
var moneyInMachine = 550

fun main() {
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")

        when (scanner.next()) {
            "remaining" -> showCoffeeMachineBalance()
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "exit" -> return
        }
    }
}

fun makeCoffee(waterForCoffee: Int, milkForCoffee: Int, beansForCoffee: Int, priceCoffee: Int) {
    val enoughWater = waterInMachine > waterForCoffee
    val enoughMilk = milkInMachine > milkForCoffee
    val enoughBeans = beansInMachine > beansForCoffee
    val enoughCups = cups >= 1

    when {
        !enoughWater -> println("Sorry, not enough water!")
        !enoughMilk -> println("Sorry, not enough milk!")
        !enoughBeans -> println("Sorry, not enough beans!")
        !enoughCups -> println("Sorry, not enough cups!")
        else -> {
            waterInMachine -= waterForCoffee
            milkInMachine -= milkForCoffee
            beansInMachine -= beansForCoffee
            cups -= 1
            moneyInMachine += priceCoffee
            println("I have enough resources, making you a coffee!")
        }
    }
}

fun buy() {
    val scanner = Scanner(System.`in`)

    val waterForEspresso = 250
    val milkForEspresso = 0
    val beansForEspresso = 16
    val priceEspresso = 4

    val waterForLatte = 350
    val milkForLatte = 75
    val beansForLatte = 20
    val priceLatte = 7

    val waterForCappuccino = 200
    val milkForCappuccino = 100
    val beansForCappuccino = 12
    val priceCappuccino = 6

    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")

    when (scanner.next()) {
        "1" -> makeCoffee(waterForEspresso, milkForEspresso, beansForEspresso, priceEspresso)
        "2" -> makeCoffee(waterForLatte, milkForLatte, beansForLatte, priceLatte)
        "3" -> makeCoffee(waterForCappuccino, milkForCappuccino, beansForCappuccino, priceCappuccino)
        "back" -> return
        else -> buy()
    }
}

fun fill() {
    print("Write how many ml of water do you want to add: ")
    waterInMachine += scanner.nextInt()
    print("Write how many ml of milk do you want to add: ")
    milkInMachine += scanner.nextInt()
    print("Write how many grams of coffee beans do you want to add: ")
    beansInMachine += scanner.nextInt()
    print("Write how many disposable cups of coffee do you want to add: ")
    cups += scanner.nextInt()
}

fun take() {
    println("I gave you $moneyInMachine")
    moneyInMachine = 0
}

fun showCoffeeMachineBalance() {
    println("The coffee machine has: " +
            "\n$waterInMachine of water" +
            "\n$milkInMachine of milk" +
            "\n$beansInMachine of coffee beans" +
            "\n$cups of disposable cups" +
            "\n$moneyInMachine of money")
}
