package com.example.leetcode.string

// Count the frequency of each character in a string
fun getUniqueCharacters(text: String): Set<Char> {
    val uniqueCharacters = mutableSetOf<Char>()

    for (char in text) {
        if (char.isLetter()) {
            uniqueCharacters.add(char.lowercaseChar())
        }
    }

    return uniqueCharacters
}

fun countCharacterFrequency(text: String): Map<Char, Int> {
    val frequencyMap = mutableMapOf<Char, Int>()

    for (char in text) {
        if (char.isLetter()) {
            val lowercaseChar = char.lowercaseChar()
            val count = frequencyMap.getOrDefault(lowercaseChar, 0)
            frequencyMap[lowercaseChar] = count + 1
            //frequencyMap[lowercaseChar] = frequencyMap.getOrDefault(lowercaseChar, 0) + 1
        }
    }

    return frequencyMap
}

fun countCharacterFrequencyWithArray(text: String): IntArray {
    val frequencyArray = IntArray(26) // Array to hold frequencies of characters a-z

    for (char in text) {
        if (char.isLetter()) {
            val lowercaseChar = char.lowercaseChar()
            val index = lowercaseChar - 'a' // Map character to index in the array
            frequencyArray[index]++
        }
    }

    return frequencyArray
}

fun countDigitFrequencyWithArray(text: String): IntArray {
    val frequencyArray = IntArray(10) // Array to hold frequencies of digits 0-9

    for (char in text) {
        if (char.isDigit()) {
            val digit = char - '0' // Map character to index in the array
            frequencyArray[digit]++
        }
    }

    return frequencyArray
}

fun extractDigitsFromString(text: String) {
    for (char in text) {
        if (char.isDigit()) {
            val digit = char.toString().toInt()
            println("Digit: $digit")
        }
    }

    val regex = Regex("\\d") // Matches any digit
    val matches = regex.findAll(text)

    matches.map { it.value.toInt() }.forEach {
        println("Digit: $it")
    }

    for (match in matches) {
        val digit = match.value.toInt()
        println("Digit: $digit")
    }

    text.filter {
        it.isDigit()
    }.map {
        it.toString().toInt()
    }.toList().forEach {
        println("Digit: $it")
    }
    // don't convert charactor in to integer directly, as you will get the ascii value of the charactor
    // instead convert the charactor to string and then to integer
}

fun main() {
    val text = "Hello, world!"
    val frequencyMap = countCharacterFrequency(text)

    println(frequencyMap)

    val uniqueCharacters = getUniqueCharacters(text)
    println(uniqueCharacters)

    val frequencyArray = countCharacterFrequencyWithArray(text)
    // Printing the frequency of each character
    for (i in 0 until 26) {
        val char = (i + 'a'.toInt()).toChar()
        println("$char: ${frequencyArray[i]}")
    }

    val digitText = "1234567890 9876543210"
    val digitFrequencyArray = countDigitFrequencyWithArray(digitText)
    println("Digit Frequency Array")
    println("Digit Frequency Array: ${digitFrequencyArray.toList()}")
    // Printing the frequency of each digit
    for (i in 0 until 10) {
        println("$i: ${digitFrequencyArray[i]}")
    }

    extractDigitsFromString("98456")

}
// Output: {h=1, e=1, l=3, o=2, w=1, r=1, d=1}