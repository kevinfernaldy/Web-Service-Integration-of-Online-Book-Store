<?php
$client = new SoapClient("http://localhost:9901/GetBookByTitle?wsdl");

class MyBook {
    public $id;
    public $title;
    public $imageUrl;
    public $description;
    public $forSale;
    public $price;
    public $currency;
    public $author;
}

$r = $client->GetBookByTitle();
var_dump($r);

?>
