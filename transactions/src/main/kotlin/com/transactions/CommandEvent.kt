package com.transactions

import org.springframework.context.ApplicationEvent

 class CommandEvent(
     val command: Any,
 ): ApplicationEvent(command) {

}
