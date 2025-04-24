import './App.css'
import ChatInput from "./components/ChatInput.jsx";
import ChatResponse from "./components/ChatResponse.jsx";
import {useState} from "react";

function App()
{
    const [response, setResponse] = useState(null);
    const [loading, setLoading] = useState(false);

    const handleQuestionSubmit = async (question) => {
        setLoading(true);
        setResponse(null);
        try {
            const apiResponse = await fetchChatResponse(question);
            setResponse(apiResponse);
        } catch (error) {
            alert("Failed to get response")
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className='App'>
            <header className='bg-primary text-white text-center py-4'>
                <h1>Gemini ChatBot</h1>
            </header>
            <ChatInput onSubmit={handleQuestionSubmit}/>
            {loading && <h3>Loading...</h3>}
            <ChatResponse response={response}/>
            {/* RESPONSE */}
        </div>
    )
}

export default App
