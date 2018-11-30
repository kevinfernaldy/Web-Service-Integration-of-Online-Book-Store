<?php
$client = new SoapClient("http://localhost:9901/GetRecomendedBook/Recommend?wsdl");

class MyBook {
    public $id;
    public $title;
    public $authors;
    public $description;
    public $textSnippet;
    public $list_price;
    public $retail_price;
    public $category_id;
}

$category = '2';
$r = $client->GetRecommendBook(array('arg0' => $category));
var_dump($r);
?>
