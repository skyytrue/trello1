package kz.bitlab.trello1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Check;

public record TaskFullRecord(
        @NotNull
        @Schema(description = "Идентификатор задачи", example = "1", required=false)
        Long id,

        @NotNull
        @Schema(description = "Имя задачи", example = "Cделать домашку" ,required = false)
        String title,

        @Schema(description = "Описание задачи" , example = "Сделать домашнее задание",required = false)
        String description,

        @NotNull
        @Schema(description = "Статус задачи", example = "IN_PROGRESS", required = true)
        String status,

        @NotNull
        @Schema(description = "Исполнитель задачи" , example = "1", required = true)
        Long userId
) {
}
