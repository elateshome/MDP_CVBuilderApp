package com.example.mdp_cvbuilderapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mdp_cvbuilderapp.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private lateinit var binding: FragmentContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_contact, container, false)
        binding = FragmentContactBinding.bind(view)

        binding.mobile.img.setImageResource(R.drawable.phone)
        binding.mobile.tv1.text = resources.getString(R.string.mynumber)
        binding.mobile.tv2.text = resources.getString(R.string.phone)
        binding.mobile.tv1.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            val et2 = resources.getString(R.string.mynumber)
            intent.data = Uri.parse("tel:$et2")
            startActivity(intent)
        }

        binding.linkedin.img.setImageResource(R.drawable.linked)
        binding.linkedin.tv1.text = resources.getString(R.string.my_linkedin_account)
        binding.linkedin.tv2.text = resources.getString(R.string.linkedin)
        binding.linkedin.tv1.setOnClickListener{
            val uri = Uri.parse(resources.getString(R.string.my_linkedin_account));
            val it = Intent(Intent.ACTION_VIEW,uri);
            startActivity(it);
        }

        binding.email.img.setImageResource(R.drawable.mail)
        binding.email.tv1.text = resources.getString(R.string.email_account)
        binding.email.tv2.text = resources.getString(R.string.email)
        binding.email.tv1.setOnClickListener{

            val emailIntent = Intent(
                Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", resources.getString(R.string.email_account), null
                )
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, R.string.email_body)
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        binding.github.img.setImageResource(R.drawable.github)
        binding.github.tv1.text = resources.getString(R.string.my_github_account)
        binding.github.tv2.text = resources.getString(R.string.github)
        binding.github.tv1.setOnClickListener{
            val uri = Uri.parse(resources.getString(R.string.my_github_account));
            val it = Intent(Intent.ACTION_VIEW,uri);
            startActivity(it);
        }



        return view
    }

}