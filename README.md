# Расширение для HashMap

Разработать класс расширение для HashMap(Kotlin, Rust) или dict(Python) для организации дополнительных способов
получения элементов.

Первый способ доступа: доступ по номеру ключа, ключи должны быть отсортированы(метод toSortedSet)

Пример:

```kotlin
val map = SpecialHashMap()
map["value1"] = 1
map["value2"] = 2
map["value3"] = 3
map["1"] = 10
map["2"] = 20
map["3"] = 30
map["1, 5"] = 100
map["5, 5"] = 200
map["10, 5"] = 300

println(map.iloc[0])  // >>> 10
println(map.iloc[2])  // >>> 300
println(map.iloc[5])  // >>> 200
println(map.iloc[8])  // >>> 3
```

Второй способ доступа:  выборка всех пар ключ:значение по определенному условию.

Пример:

```kotlin
val map = SpecialHashMap()
map["value1"] = 1
map["value2"] = 2
map["value3"] = 3
map["1"] = 10
map["2"] = 20
map["3"] = 30
map["(1, 5)"] = 100
map["(5, 5)"] = 200
map["(10, 5)"] = 300
map["(1, 5, 3)"] = 400
map["(5, 5, 4)"] = 500
map["(10, 5, 5)"] = 600

println(map.ploc[">=1"]) // >>> {1=10, 2=20, 3=30}
println(map.ploc["<3"]) // >>> {1=10, 2=20}

println(map.ploc[">0, >0"]) // >>> {(1, 5)=100, (5, 5)=200, (10, 5)=300}
println(map.ploc[">=10, >0"]) // >>> {(10, 5)=300}

println(map.ploc["<5, >=5, >=3"]) // >>> {(1, 5, 3)=400}
```

Для второго доступа:

* Для условий используются символы: <. >, = и их комбинации, для не равно используется комбинация <>
* В условии может быть любое количество пробелов
* В условии используются только целые и вещественные числа
* В качестве разделителя могут выступать любые символы, кроме символов условий и чисел
* Ключи должны соответствовать количеству условий, т.е. если в ключе два числа, а в условии три, то такой ключ
  игнорируется
* Скобки являются необязательными и игнорируются при выборе

Общие требования:

* Дополнительные способы должны быть доступны через поля iloc и ploc
* Должно быть определено исключение для неверно заданных условий
* Должны быть написаны тесты для проверки всего кода
* Код может быть реализовано на одном из языков: Kotlin, Rust или Python.

## Демонстрация работы:

| Проверка iloc | 
| ----------- |
| ![](https://gitlab.com/ISU-Applied-Computer-Science/5th-semester/theory-and-practice-of-programming-languages/Hashmap-extension/-/raw/main/raw/demo_1.png?inline=false) | 
| ![](https://gitlab.com/ISU-Applied-Computer-Science/5th-semester/theory-and-practice-of-programming-languages/Hashmap-extension/-/raw/main/raw/demo_2.png?inline=false) | 

| Проверка ploc | 
| ----------- |
| ![](https://gitlab.com/ISU-Applied-Computer-Science/5th-semester/theory-and-practice-of-programming-languages/Hashmap-extension/-/raw/main/raw/demo_3.png?inline=false) | 
| ![](https://gitlab.com/ISU-Applied-Computer-Science/5th-semester/theory-and-practice-of-programming-languages/Hashmap-extension/-/raw/main/raw/demo_4.png?inline=false) |

| Coverage | 
| ----------- |
| ![](https://gitlab.com/ISU-Applied-Computer-Science/5th-semester/theory-and-practice-of-programming-languages/Hashmap-extension/-/raw/main/raw/demo_5.png?inline=false) |  

