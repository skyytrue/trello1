package kz.bitlab.trello1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record TaskCreateRecord(@NotNull
                               @Schema(description = "Имя задачи", example = "Сделать домашку", required= true)
                               String title,

                               @NotNull
                               @Schema(description = "Описание задачи", example="Сдеалть домашнее задание по JAVA", required=false)
                               String description,

                               @Schema(description = "Исполнитель задачи Id", example = "1", required=false)
                               Long userId
) {

}
