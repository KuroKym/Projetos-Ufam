#include <stdio.h>
#include <stdlib.h>
#include <GL/glut.h>
#include <time.h>

int linhas = 0; // Número de linhas aleatórias

typedef struct {
    float x, y;
} Point;

int ccw(Point A, Point B, Point C) {
    return (C.y - A.y) * (B.x - A.x) > (B.y - A.y) * (C.x - A.x);
}

int intersect(Point A, Point B, Point C, Point D) {
    return ccw(A, C, D) != ccw(B, C, D) && ccw(A, B, C) != ccw(A, B, D);
}

void display(void) {
    glClear(GL_COLOR_BUFFER_BIT);

    glColor3f(0.0, 1.0, 0.0);  // Define a cor para verde
    glBegin(GL_LINES);

    Point *points = (Point *)malloc(linhas * 2 * sizeof(Point));
    int count = 0;

    for (int i = 0; i < linhas; ++i) {
        Point A = { (float)(rand() % 300), (float)(rand() % 300) };
        Point B = { (float)(rand() % 300), (float)(rand() % 300) };

        int intersects = 0;
        for (int j = 0; j < count; j += 2) {
            if (intersect(A, B, points[j], points[j + 1])) {
                intersects = 1;
                break;
            }
        }

        if (!intersects) {
            glVertex2f(A.x, A.y);
            glVertex2f(B.x, B.y);
            points[count++] = A;
            points[count++] = B;
        }
    }

    free(points);
    glEnd();
    glFlush();  // Certifique-se de que os comandos de renderização sejam executados
}

int main(int argc, char **argv) {
    srand(time(NULL));  // Inicializa o gerador de números aleatórios com o tempo atual

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(atoi(argv[1]), atoi(argv[2]));
    linhas = atoi(argv[3]);
    glutCreateWindow("Segmentos Aleatorios");
    
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0.0, 300.0, 0.0, 300.0, -1.0, 1.0);
    
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}
