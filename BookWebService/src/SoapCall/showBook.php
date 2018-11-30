<?php
$client = new SoapClient("http://localhost:9901/GetBookByTitle?wsdl");

class MyBook {
    public $id;
    public $title;
    public $list_price;
    public $retail_price;
    public $category_id;
}

$r = $client->GetBookByTitle();
var_dump($r);

?>
