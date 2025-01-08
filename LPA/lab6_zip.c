#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int count = 1;

#pragma pack(1)
struct zip_file_hdr {
    int signature;
    short version;
    short flags;
    short compression;
    short mod_time;
    short mod_date;
    int crc;
    int compressed_size;
    int uncompressed_size;
    short name_length;
    short extra_field_length;
};

void imprimir_info(FILE *zip_file, struct zip_file_hdr *file_hdr) {
    char *zipFile = (char *)malloc(file_hdr->name_length + 1);
    fread(zipFile, 1, file_hdr->name_length, zip_file);
    zipFile[file_hdr->name_length] = '\0';

    fseek(zip_file, file_hdr->extra_field_length, SEEK_CUR);

    printf("Arquivo %d ..\n", count);
    printf("  --> Nome do Arquivo: %s\n", zipFile);
    printf("  --> Tamanho Compactado: %d\n", file_hdr->compressed_size);
    printf("  --> Tamanho Descompactado: %d\n", file_hdr->uncompressed_size);
    count++;

    free(zipFile);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Uso: %s <arquivo_zip>\n", argv[0]);
        return 1;
    }

    FILE *zip_file = fopen(argv[1], "rb");
    if (!zip_file) {
        printf("Erro ao abrir o arquivo ZIP");
        return 1;
    }

    struct zip_file_hdr file_hdr;
    while (fread(&file_hdr, sizeof(struct zip_file_hdr), 1, zip_file) == 1) {
        if (file_hdr.signature != 0x04034b50) {
            break; 
        }

        imprimir_info(zip_file, &file_hdr);

        fseek(zip_file, file_hdr.compressed_size, SEEK_CUR);
    }

    fclose(zip_file);
    return 0;
}
