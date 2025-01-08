#include <stdio.h>
#include <stdlib.h>
#include <arpa/inet.h>  // Para usar ntohl no Linux
#include <string.h>     // Para usar strncmp

// Estrutura para representar o cabeçalho de um chunk PNG
struct png_chunk {
    unsigned int length; // Tamanho do chunk
    char type[4];        // Tipo do chunk
} __attribute__ ((packed));

// Estrutura para representar o chunk IHDR
struct ihdr_chunk {
    unsigned int width;
    unsigned int height;
    unsigned char bit_depth;
    unsigned char color_type;
    unsigned char compression_method;
    unsigned char filter_method;
    unsigned char interlace_method;
} __attribute__ ((packed));

typedef struct png_chunk png_chunk;
typedef struct ihdr_chunk ihdr_chunk;

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <arquivo_png>\n", argv[0]);
        return 1;
    }

    FILE *png_file = fopen(argv[1], "rb"); // Abre o arquivo em modo binário
    if (!png_file) {
        perror("Erro ao abrir o arquivo PNG");
        return 1;
    }


    png_chunk *chunk = malloc(sizeof(png_chunk));
    ihdr_chunk *ihdr = malloc(sizeof(ihdr_chunk));
    int count = 1;

    // Pula a assinatura PNG (8 bytes)
    fseek(png_file, 8, SEEK_SET);
    while(!feof(png_file)){
        if(fread(chunk, sizeof(struct png_chunk), 1, png_file) != 1){
            printf("deu erro\n");
            break;
        }
        
        printf("Lendo chunk %d:\n", count);
        printf(" --> Tamanho: %d\n", ntohl(chunk->length));
        printf(" --> Tipo: %.4s\n", chunk->type);
        count++;

        if(strncmp(chunk->type, "IHDR", 4) == 0){
            fread(ihdr, sizeof(struct ihdr_chunk), 1, png_file);
            printf(" --> Largura: %u\n", ntohl(ihdr->width));
            printf(" --> Altura: %u\n", ntohl(ihdr->height));
            fseek(png_file, 4, SEEK_CUR);
            
        }
        else if(strncmp(chunk->type, "IEND", 4) == 0){
            break;
        }
        else{
            fseek(png_file, ntohl(chunk->length) +4, SEEK_CUR);
        }
        
    }
    free(chunk);
    free(ihdr);
    fclose(png_file);

    return 0;
}