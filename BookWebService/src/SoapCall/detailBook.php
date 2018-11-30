<?php
$client = new SoapClient("http://localhost:9901/GetBookByID/Detail?wsdl");

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

$google_id = 'DdUKAAAAQBAJ';
$r = $client->GetBookByID(array('arg0' => $google_id));
var_dump($r);
?>
