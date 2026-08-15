<?php 

namespace App\Services;

use GuzzleHttp\Client;
use GuzzleHttp\Exception\RequestException;

class DeepSeekService
{
    protected $client;
    protected $apiKey;
    protected $baseUrl = 'https://api.deepseek.com/v1';

    public function __construct()
    {
        $this->client = new Client();
        $this->apiKey = env('DEEPSEEK_API_KEY');
    }

    public function chat(array $messages)
    {
        try {
            $response = $this->client->post("{$this->baseUrl}/chat/completions",
            [
                'headers' => [
                    'Authorization' => 'Bearer ' . $this->apiKey,
                    'Content-Type' => 'application/json',
                ],
                'json' => [
                    'messages' => $messages,
                    'model' => 'deepseek-free',
                ],
            ]);
            return json_decode($response->getBody(),true);
        } catch (RequestException $e){
            return[
                'error' => true,
                'message' => $e->getMessage(),
            ];
        }
        
    }
}