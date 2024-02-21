package com.didenko.starcruises.entity;


import lombok.Getter;

public enum TicketState {

   NOT_PAID(1), PENDING(2), PAID(3), COMPLETED(4), CANCELLED(5);

   @Getter
   private final Integer order;

   TicketState(Integer order){
      this.order = order;
   }

}
