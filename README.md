# BezierCurves
We made a graphical representation of Bézier Curves using Java Swing with @semihAkkoc 
## What are they?
Think of two points A, B and a parameter t where 0 ≤ t ≤ 1. Draw a line segment between A and B. The parameter t defines our position on this line segment, 0 being at A and 1 being at B. For example, t = 0.5 would define the center point of the line segment and t = 0.25 would define the point on the line segment where the distance to B is three times as big as distance to A.
The function that does this process is called lerp (linear interpolation). The beauty of this function is revealed when we combine multiple linear interpolation processes together. When we trace the resulting points, we get what is called a Bézier curve. The most common type of Bézier curves, cubic Bézier curves, happens to be the result of 4 points and one lerp of lerps of lerps.
>You should check this wonderful video for a better understanding of what Bézier curves are: https://www.youtube.com/watch?v=aVwxzDHniEw
## What did we do?
We used a plane -although it is possible to recreate Bézier curves in space- to create anchor points and handles on (as they are called in many vector based graphical applications) and used many lerps to find their positions. We then drew them on the frame to be able to visualise them, which is the whole point.
We hope you like it!
### TO-DO
- [ ] Handles and anchors made interactive
- [ ] Tangent lines made visible for better representation
