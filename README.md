# SweetTreet

## Descripción
El sistema SweetTreet es una aplicación de escritorio, que tiene como objetivo automatizar el proceso de venta y ayudar con la gestión del inventario de la tienda de dulces.  

El cajero tendrá la oportunidad de crear nuevas ventas ya sea con una reservación o entrega al momento. <br>
Para el caso del administrador podrá administrar el inventario de la tienda y generar reportes diarios, semanales, mensuales, etc. <br>
Ambos usuarios, tendrán que iniciar sesión en el sistema para poder usarlo. 

## Demo 

#### Inicio de Sesión: 
<img width="746" height="450" alt="image" src="https://github.com/user-attachments/assets/e3b81bc1-b5ae-46c3-bf43-16ea05160a22" />

<hr>

#### Menú administrador: 
<img width="541" height="256" alt="image" src="https://github.com/user-attachments/assets/76e1f333-190f-41b2-9b31-0d53b2983a0c" />

<br><br>

- Agregar nuevo producto
<img width="544" height="192" alt="image" src="https://github.com/user-attachments/assets/56523851-7834-4e5c-b821-fb5d36d47289" />
<img width="429" height="104" alt="image" src="https://github.com/user-attachments/assets/5f2dd350-4908-4fa8-8583-49c89e9c4074" />

<br><br>

- Modificar producto
<img width="628" height="506" alt="image" src="https://github.com/user-attachments/assets/de8c4fd7-40dd-4822-80fa-31c7b78e1fd8" />

<br><br>

- Eliminar producto
<img width="530" height="559" alt="image" src="https://github.com/user-attachments/assets/c22cbd51-bdbb-436d-81ff-79ee4690ba2c" />
<p></p>
<img width="478" height="552" alt="image" src="https://github.com/user-attachments/assets/6cc5f9e0-1de1-4c9c-9024-8e7e060dcc51" />

<br><br>

- Generar reporte
<img width="571" height="235" alt="image" src="https://github.com/user-attachments/assets/a0247f8b-c190-4efe-941e-a1fd2d754d8b" />
<p></p>
<img width="301" height="259" alt="image" src="https://github.com/user-attachments/assets/55b10fd9-c460-4d14-abe4-3b50ceb137bb" />

<hr>

#### Menú cajero: 

<img width="562" height="350" alt="image" src="https://github.com/user-attachments/assets/914fb646-394e-4587-ac6e-9f4aa9d3a953" />
<p></p>
<img width="552" height="534" alt="image" src="https://github.com/user-attachments/assets/9653a6a6-f308-4dce-9a20-fe436e8e7877" />

<br><br>

- Venta de productos
<img width="484" height="283" alt="image" src="https://github.com/user-attachments/assets/ec15d213-cea7-423f-a49a-8ee27a4313d5" />
<p></p>
<img width="576" height="541" alt="image" src="https://github.com/user-attachments/assets/7c7bc433-ad90-4184-b1ab-e9c66a200557" />

<br><br>

- Generar venta apartada
<img width="501" height="205" alt="image" src="https://github.com/user-attachments/assets/d63ed449-e5c3-4837-a7d0-a0cbec9c79c8" />
<p></p>
<img width="508" height="418" alt="image" src="https://github.com/user-attachments/assets/fb6a974e-ef2b-49ec-a7d7-b5a9662692ae" />
<p></p>
<img width="530" height="506" alt="image" src="https://github.com/user-attachments/assets/7b635ff8-32fe-408f-9141-25cdc8071331" />
<p></p>
<img width="480" height="173" alt="image" src="https://github.com/user-attachments/assets/7c58bd74-1a6f-4de3-a793-2f33716cb6b5" />

<br><br>

- Ver catálogo
<img width="577" height="575" alt="image" src="https://github.com/user-attachments/assets/3e2f1435-15a4-43cc-8884-7322dc96e907" />
<p></p>
<img width="451" height="464" alt="image" src="https://github.com/user-attachments/assets/e0f240b3-e99a-43ad-b932-c1fb46a289a2" />

<br><br>

- Seguimiento de pedido
<img width="340" height="353" alt="image" src="https://github.com/user-attachments/assets/fea8b47a-a9a7-4844-91fc-6d1270b227f0" />
<p>Cambiamos de estado </p>
<img width="666" height="170" alt="image" src="https://github.com/user-attachments/assets/2a70e23f-ccac-4001-9ca5-53b56580e9e7" />
<br>
<p>Entregamos el pedido</p>
<img width="392" height="150" alt="image" src="https://github.com/user-attachments/assets/2dbb8571-4195-498c-accc-646702d89320" />
<br>
<p>Se elimina de la lista de pedidos</p>
<img width="219" height="227" alt="image" src="https://github.com/user-attachments/assets/fc0d5b72-bb89-4d23-98d7-0bb7f57da4d7" />

<hr>

#### Salir del sistema: 
<img width="971" height="669" alt="image" src="https://github.com/user-attachments/assets/1da50109-db43-441f-8c68-8a169a86a1bd" />

<hr>

## Features

- Búsqueda de productos
- Inicio de sesión
- Validación de la venta
- Cobro de servicio
- Añadir elementos extras
- Gestionar inventario
- Generar compra
- Seguimiento de pedidos
- Generación de Reportes
- Administración de usuarios  

## Arquitectura
El proyecto sigue una arquitectura orientada a objetos basada en la separación de responsabilidades entre la gestión de inventario, ventas, apartados, pagos y generación de reportes. 
El diseño utiliza patrones de diseño  para facilitar el mantenimiento y la escalabilidad del sistema.

### Diagrama de Clases

#### Diagrama de clases sin el uso de patrones de diseño:
<img width="1377" height="843" alt="image" src="https://github.com/user-attachments/assets/9f4615b8-7501-4c0f-b68b-4f842d91f9a2" />

Al revisar el diagrama de clases, identificamos las complejidades potenciales y las oportunidades disponibles en nuestra propuesta. Nos centramos en simplificar las 
relaciones entre objetos, buscando optimizar el flujo de trabajo.
Nuestro objetivo es optimizar la programación mediante la implementación de patrones que simplifiquen la lógica, en lugar de añadir complejidad al sistema.
Esta revisión nos permite mejorar la claridad del diseño y potenciar la eficiencia en el desarrollo.

<br><br>

#### Diagrama de clases final 
El siguiente diagrama representa la estructura final del sistema:

<img width="924" height="1125" alt="image" src="https://github.com/user-attachments/assets/10ee2aa4-57cf-49c8-9417-5fd2cf1f72ca" />

<b>Simbología:</b>

- [ROJO] Patrón Fachada
- [VERDE] Patrón Singleton
- [AZUL] Patrón Factory Method 

### Patrones de Diseño Utilizados

<b>Singleton</b>
- Solo debe existir una instancia de la clase Historial.
- La instancia solo es accedida desde Caja por el método Instance.
<br>

<b>Factory Method</b>
- La clase Venta hace uso del polimorfismo para  crear un objeto de tipo pago delegando la responsabilidad a sus subclases concretas.
<br>

<b>Fachada</b>
- La clase Caja unifica las interfaces de Venta, Historial y Catálogo, facilitando su uso para el Usuario. 


### Herencia y Polimorfismo

- Venta → ComponenteVenta, ComponenteVentaApartada
- Pago → PagoVenta, PagoVentaApartada
  

## Tecnologias
- JAVA
- Apache NetBeans
  

## Autores

- Espinosa Tlatelpa Darina Jocelyn
- Quiroz Castillo José Fernando
- Mendoza Armas Juan Pablo
- Ramírez Martínez Ana Karen

