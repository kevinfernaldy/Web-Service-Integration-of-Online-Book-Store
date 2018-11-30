<?php
$client = new SoapClient("http://localhost:9901/GetRecomendedBook/Recommend?wsdl");

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

$category = '2';
$r = $client->GetRecommendBook(array('arg0' => $category));
var_dump($r);
?>
