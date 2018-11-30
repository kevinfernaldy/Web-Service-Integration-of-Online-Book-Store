<?php
$client = new SoapClient("http://localhost:9901/GetBookByID/Detail?wsdl");

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

$google_id = 'DdUKAAAAQBAJ';
$r = $client->GetBookByID(array('arg0' => $google_id));
var_dump($r);
?>
