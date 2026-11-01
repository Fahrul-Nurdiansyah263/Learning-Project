<?php

namespace App\Http\Controllers;

use App\Services\DeepSeekService;
use Illuminate\Http\Request;

class DeepSeekController extends Controller
{
    protected $deepSeekService;

    public function __construct(DeepSeekService $deepSeekService)
    {
        $this->deepSeekService = $deepSeekService;
    }

    public function chat(Request $request)
    {
        $messages = $request->input('messages', []);

        $response = $this->deepSeekService->chat($messages);
        
        if (isset($response['error'])) {
            return response()->json(['error' => $response['message']], 500);

        }

        return response()->json($response);
    }
}
