## Console Drawer

A tiny console drawer program

### Commands   
| Command | Description |
| ------- | ----------- |
| `C w h`     | Should create a new canvas of width w and height h. |
| `L x1 y1 x2 y2` | Should create a new line from `(x1,y1)` to `(x2,y2)`. Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the `x` character. |
| `R x1 y1 x2 y2` | Should create a new rectangle, whose upper left corner is `(x1,y1)` and lower right corner is `(x2,y2)`. Horizontal and vertical lines will be drawn using the `x` character. |
| `B x y c` | Should fill the entire area connected to `(x,y)` with colour `'c'`. The behaviour of this is the same as that of the "bucket fill" tool in paint programs. |
| `Q` | Should quit the program. |
 
## Sample I/O

Below is a sample of the output . User input is prefixed with `enter command:`.


	enter command: C 20 4
	----------------------
	|                    |
	|                    |
	|                    |
	|                    |
	----------------------
	
	enter command: L 1 2 6 2
	----------------------
	|                    |
	|xxxxxx              |
	|                    |
	|                    |
	----------------------
	
	enter command: L 6 3 6 4
	----------------------
	|                    |
	|xxxxxx              |
	|     x              |
	|     x              |
	----------------------
	
	enter command: R 16 1 20 3
	----------------------
	|               xxxxx|
	|xxxxxx         x   x|
	|     x         xxxxx|
	|     x              |
	----------------------
	
	enter command: B 10 3 o
	----------------------
	|oooooooooooooooxxxxx|
	|xxxxxxooooooooox   x|
	|     xoooooooooxxxxx|
	|     xoooooooooooooo|
	----------------------
	
	enter command: Q


##Build and Run
```yaml
 mvn clean install
 
 java -jar <jar_location>/drawer.jar 
```

Build without running tests
```yaml
 mvn clean install -DskipTests=true
```
