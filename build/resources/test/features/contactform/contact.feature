Feature: Conctactanos Usuario
  Yo como usuario de la plataforma
  Deseo enviar un mensaje a soporte
  para dejar una sugerencia o problema

  @Regresion
  Scenario: El usuario ingresa al sistema un nombre, email, telefono y mensaje correctos
    Given que el usuario desea enviar un mensaje a soporte
    When el usuario ingresa e la plataforma un nombre, telefono,email y mensaje correctos
    Then se mostrara un mensaje

  @Regresion
  Scenario: El usuario ingresa al sistema un email invalido
    Given que el usuario desea enviar un mensaje
    When el usuario ingresa e la plataforma un nombre, telefono y mensaje validos y un email invalido
    Then se mostrara un mensaje de error

  @Regresion
  Scenario: El usuario ingresa al sistema un telefono invalido
    Given que el usuario desea enviar un mensaje pero con numero de telefono invalido
    When el usuario ingresa e la plataforma un nombre,email y mensaje validos y un telefono invalido
    Then se va a mostrar un mensaje de error

  @Regresion
  Scenario: El usuario ingresa al sistema un nombre invalido
    Given que el usuario desea enviar un mensaje pero no quiere poner su nombre
    When el usuario ingresa e la plataforma un telefono,email y mensaje validos y un nombre invalido
    Then se va a mostrar un mensaje erroneo