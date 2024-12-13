<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Confirmar Eliminación</title>
        <link rel="stylesheet" href="bootstrap-4.4.1.css">
        <style>
            body {
                background-color: rgb(215,215,163) ; /* Fondo más suave */
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .container {
                width: 100%;
                max-width: 600px; /* Máximo ancho para mantenerlo estético */
            }
            .modal-content {
                border-radius: 10px;
                border: none;
            }
            .modal-header {
                background-color: #e74c3c;
                color: white;
                border-radius: 10px 10px 0 0;
                text-align: center;
                padding: 20px;
                font-size: 1.3rem;
            }
            .modal-body {
                text-align: center;
                padding: 30px;
            }
            .btn-group .btn {
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div class="container ">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirmar Eliminación</h5>
                </div>
                <div class="modal-body">
                    <p>¿Estás seguro de que deseas eliminar este cliente?</p>
                    <div class="btn-group">
                        <form action="ClienteServlet" method="post">
                            <input type="hidden" name="action" value="eliminarCliente">
                            <input type="hidden" name="idCliente" value="<%= request.getAttribute("idCliente") %>">
                            <button type="submit" class="btn btn-danger mr-4">Sí, eliminar</button>
                        </form>
                        <a href="ClienteServlet" class="btn btn-secondary ml-4">Cancelar</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>