# 02104 Simple Breakout
This is group 15's simple breakout for the January course 02104

## Installation
1. Close the repository (UPDATE PATH WHEN PROGRAM IS FULLY COMPILED)
```bash
git clone https://github.com/slayervictor/02104
```

## Usage
1. To run the program you can simply double click the .jar file. then the game will start with a 10 x 20 grid of blocks.
2. if you wish to change the amount of blocks you can open the terminal and run the following command:
```bash
java -jar simple-breakout.jar N M
```
It is important to note that N={1,...,10} and m={5,...,20}.

### Keybindings
To move left pres the 'h' key, and to move right press the 'l' key

## Dependencies
1. Java 21
2. JavaFX (Compatible version) - for GUI elements
3. Git - for installation

## Presets

### Easy
```bash
java -jar simple-breakout.jar 3 5
```

### Medium
```bash
java -jar simple-breakout.jar 3 5
```

### Hard
```bash
java -jar simple-breakout.jar 10 20
```

## License
MIT
