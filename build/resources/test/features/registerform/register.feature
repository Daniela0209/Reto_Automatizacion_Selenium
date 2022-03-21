Feature: Registro del usuario
  Yo como usuario de la plataforma
  Deseo registrarme con mis datos personales
  Para poder interactuar en la plataforma

  @Regresion
  Scenario: El usuario ingresa los datos en la plataforma validos
    Given que quiere crear una cuenta para ingresar
    When El usuario ingresa los siguientes datos: nombre, apellido,  direccion, ciudad, estado, codigozip, numero telefono, identificacion, usuario y contrasena
    Then se creara un usuario valido para poder ingresar a la plataforma

  @Regresion
  Scenario: El usuario no ingresa el nombre
    Given que desea crear una cuenta para ingresar
    When El usuario ingresa los siguientes datos: apellido,  direccion, ciudad, estado, codigozip, numero telefono, identificacion, usuario y contrasena
    Then sale un mensaje de error por no ingresar el nombre