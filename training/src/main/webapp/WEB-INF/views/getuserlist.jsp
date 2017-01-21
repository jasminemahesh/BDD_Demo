<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Test</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            var persons = [
                { "name": "John Doe", "address": "Main Street 1" },
                { "name": "Jane Doe", "address": "Baker Street 1" },
                { "name": "Jack Doe", "address": "Church Street 1" }
            ];
            $(document).ready(function() {
                var table = $('<table/>').appendTo($('#somediv'));
                $(persons).each(function(i, person) {
                    $('<tr/>').appendTo(table)
                        .append($('<td/>').text(person.name))
                        .append($('<td/>').text(person.address));
                });
            });
        </script>
    </head>
    <body>
        <div id="somediv"></div>
    </body>
</html>