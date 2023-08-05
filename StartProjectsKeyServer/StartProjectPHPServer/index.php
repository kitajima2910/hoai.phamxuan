<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);
header('Content-Type: application/json; charset=utf-8');
session_start();
require('core/keymodel.php');
require('core/RSACrypt.php');


$keyModel = new KeyModel();
$rsa = new RSACrypt();
$rsa->setPrivateKey('core/serverPrivate.pem');
$rsa->setPublicKey('core/clientPublic.pem');
if (isset($_POST['data'])) {
    try {
        $data = $_POST['data'];
        $data = $rsa->decryptWithPrivateKey($data);
        if ($data) {
            $testData = "Done";
            $enc = $rsa->encryptWithPublicKey($testData);
            echo json_encode(array(
                'status' => 'success',
                'data' => $enc
            ));
            return;
        }
        echo json_encode(array(
            'status' => 'failed',
            'data' => 'Không thể kết nối!'
        ));
    } catch (Exception $e) {
        echo json_encode(array(
            'status' => 'failed',
            'error' => 'Có lỗi trong quá trình gửi và nhận dữ liệu!'
        ));
    }
}

if (isset($_POST['disk'])) {
    echo $_POST['bios'];
}
