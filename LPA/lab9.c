// Nome: Jhonnatha Luiz de Souza Carvalho | Matricula: 22251129

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void split_mpg(const char *input_filename, int max_size_mb) {
    FILE *input_file = fopen(input_filename, "rb");
    if (input_file == NULL) {
        perror("Erro ao abrir o arquivo de entrada");
        exit(EXIT_FAILURE);
    }
    

    char output_filename[256];
    int part_number = 1;
    sprintf(output_filename, "video_parte_%d.mpg", part_number);
    printf("Criando arquivo video_parte_%d.mpg ...\n", part_number);
    FILE *output_file = fopen(output_filename, "wb");

    if (!output_file){
                printf("Erro ao criar o arquivo de saída.\n");
                fclose(input_file);
                exit(EXIT_FAILURE);
    }

    int max_size_bytes = max_size_mb * 1024 *1024;
    unsigned int current_size = 0;
    unsigned char buffer[4];

    while (fread(buffer, sizeof(unsigned char), 4, input_file) == 4) {
        
        if (memcmp(buffer, "\x00\x00\x01\xB3", 4) != 0 && !feof(input_file)) {
            fwrite(buffer, sizeof(unsigned char), 4, output_file);
            current_size += 4;
        }

        
        if (current_size + 4 > max_size_bytes) {
            fclose(output_file);
            part_number++;
            sprintf(output_filename, "video_parte_%d.mpg", part_number);
            printf("Criando arquivo video_parte_%d.mpg .. \n", part_number);
            output_file = fopen(output_filename, "wb");

            if (!output_file){
                printf("Erro ao criar o arquivo de saída.\n");
                fclose(input_file);
                exit(EXIT_FAILURE);
            }

            fwrite(buffer, sizeof(unsigned char), 4, output_file);

            current_size = 4;
           
        }

        if (feof(input_file)) {
            printf("Final do arquivo\n");
            fclose(output_file);
            break;
        }
    }

    fclose(input_file);
     
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Uso: %s <arquivo MPEG> <tamanho máximo em MB>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    const char *input_filename = argv[1];
    int max_size_mb = atoi(argv[2]);

    split_mpg(input_filename, max_size_mb);

    return 0;
}
