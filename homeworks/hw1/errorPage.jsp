<html>
<head>
    <title>String Reverser - Error</title>
    <style>
        html, body {
            width: 100%;
            height: 100%;
            background-color: #ea4c4c;
        }

        .content {
            position: absolute;
            left: 50%;
            top: 50%;
            -webkit-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            padding: 1em;

            text-align: center;
            font-family: Arial, serif;
            font-size: 1em;
            color: #F0F7F4;
            line-height: 180%;

            border: 3px solid;
            border-radius: 8px;
        }

        p {
            font-size: 20px;
        }
    </style>
</head>

<body>
<%@ page isErrorPage="true" %>

<div class="content">
    <h1>Oops!</h1>
    <p>Seems like there's an error :( <br> Please make sure you provided a non-empty 'str' parameter</p>
</div>
</body>
</html>