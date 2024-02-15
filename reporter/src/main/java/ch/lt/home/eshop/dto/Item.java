package ch.lt.home.eshop.dto;


import lombok.Builder;

import java.io.Serializable;

@Builder
public record Item (String id, String name, double price) implements Serializable {
}
