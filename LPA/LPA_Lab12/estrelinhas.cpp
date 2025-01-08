#include <stdio.h>
#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <vector>

using namespace cv;

typedef struct {
    Point p1, p2;
} bounding_box;

void floodFill(Mat img, int x, int y, int whiteThreshold, bounding_box *bbox) {
    if (x < 0 || x >= img.cols || y < 0 || y >= img.rows) return;
    uchar pixel = img.at<uchar>(y, x);
    if (pixel < whiteThreshold) return;

    img.at<uchar>(y, x) = 0;

    if (x < bbox->p1.x) bbox->p1.x = x;
    if (x > bbox->p2.x) bbox->p2.x = x;
    if (y < bbox->p1.y) bbox->p1.y = y;
    if (y > bbox->p2.y) bbox->p2.y = y;

    floodFill(img, x, y + 1, whiteThreshold, bbox);
    floodFill(img, x, y - 1, whiteThreshold, bbox);
    floodFill(img, x - 1, y, whiteThreshold, bbox);
    floodFill(img, x + 1, y, whiteThreshold, bbox);
}

int main(int argc, char **argv) {
    if (argc < 2) {
        printf("Sintaxe: %s <nome-arquivo-png>\n", argv[0]);
        return 1;
    }

    Mat img = imread(argv[1], IMREAD_GRAYSCALE);
    if (img.empty()) {
        printf("Não foi possível abrir o arquivo %s\n", argv[1]);
        return 1;
    }

    int whiteThreshold = 80;
    std::vector<bounding_box> stars;

    for (int y = 0; y < img.rows; y++) {
        for (int x = 0; x < img.cols; x++) {
            if (img.at<uchar>(y, x) >= whiteThreshold) {
                bounding_box bbox = { Point(img.cols, img.rows), Point(0, 0) };
                floodFill(img, x, y, whiteThreshold, &bbox);
                stars.push_back(bbox);
            }
        }
    }

    Mat imgOriginal = imread(argv[1], IMREAD_COLOR);
    if (imgOriginal.empty()) {
        printf("Não foi possível abrir o arquivo original %s\n", argv[1]);
        return 1;
    }

    for (const auto &bbox : stars) {
        rectangle(imgOriginal, bbox.p1, bbox.p2, Scalar(0, 255, 0), 1);
    }

    imwrite("output-stars.png", imgOriginal);

    printf("Número de estrelas encontradas: %lu\n", stars.size());
    return 0;
}
